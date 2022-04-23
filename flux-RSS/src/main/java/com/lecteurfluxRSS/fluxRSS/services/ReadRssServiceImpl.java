package com.lecteurfluxRSS.fluxRSS.services;

import com.lecteurfluxRSS.fluxRSS.models.Channel;
import com.lecteurfluxRSS.fluxRSS.models.Items;
import com.lecteurfluxRSS.fluxRSS.models.Media;
import com.lecteurfluxRSS.fluxRSS.repository.ChannelRepository;
import com.lecteurfluxRSS.fluxRSS.repository.ItemRepository;
import com.lecteurfluxRSS.fluxRSS.repository.MediaRepository;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import java.util.ArrayList;
import java.util.List;


import java.io.IOException;
import java.net.URL;


@Service
public class ReadRssServiceImpl implements ReadRssService{

    @Autowired
    ItemRepository itemRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Autowired
    MediaRepository mediaRepository;

    @Override
    public void saveRss() {

        try {
            URL feedSource = new URL("https://www.lemonde.fr/rss/en_continu.xml");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedSource));
            //return feed.getTitle();
            Channel channel = new Channel(feed.getTitle(), feed.getDescription(), feed.getCopyright(), feed.getLink(), feed.getPublishedDate());
            Channel channelsaved = channelRepository.save(channel);

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(String.valueOf(feedSource));

            //create an empty list for items
            //List<Items> items = new ArrayList<>();

            XPath xPath = XPathFactory.newInstance().newXPath();
            //NodeList nodeList2 = (NodeList) xPath.compile("//item").evaluate(doc, XPathConstants.NODESET);
            NodeList nodeList = (NodeList) xPath.compile("//item").evaluate(doc, XPathConstants.NODESET);
            for (int i=0; i<nodeList.getLength(); i++){
                Items item = new Items();
                item.setTitle(xPath.compile("./title").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                item.setPubDate(xPath.compile("./pubDate").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                item.setDescription(xPath.compile("./description").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                item.setLink(xPath.compile("./link").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                item.setChannel(channelsaved);

                Media media = new Media();
                media.setContent(xPath.compile("./media:content[@url]").evaluate(nodeList.item(i)));
                media.setDescription(xPath.compile("./media:content/media:description").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                media.setCredit(xPath.compile("./media:content/media:credit").evaluate(nodeList.item(i), XPathConstants.STRING).toString());

                itemRepository.save(item);
                //item.setMedia(media);
                //items.add(item);
            }

            //channel.setItems(items);

        } catch (FeedException | IOException e) {
            e.getMessage();
        } catch (XPathExpressionException | ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

    }

    @Override
    public Channel readRss() throws IOException, FeedException {
        Channel channel = null;
        try {
            URL feedSource = new URL("https://www.lemonde.fr/rss/en_continu.xml");
            SyndFeedInput input = new SyndFeedInput();
            SyndFeed feed = input.build(new XmlReader(feedSource));
            //return feed.getTitle();
            channel = new Channel(feed.getTitle(), feed.getDescription(), feed.getCopyright(), feed.getLink(), feed.getPublishedDate());


            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(String.valueOf(feedSource));

            //create an empty list for items
            List<Items> items = new ArrayList<>();

            XPath xPath = XPathFactory.newInstance().newXPath();
            //NodeList nodeList2 = (NodeList) xPath.compile("//item").evaluate(doc, XPathConstants.NODESET);
            NodeList nodeList = (NodeList) xPath.compile("//item").evaluate(doc, XPathConstants.NODESET);
            for (int i=0; i<nodeList.getLength(); i++){
                Items item = new Items();
                item.setTitle(xPath.compile("./title").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                item.setPubDate(xPath.compile("./pubDate").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                item.setDescription(xPath.compile("./description").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                item.setLink(xPath.compile("./link").evaluate(nodeList.item(i), XPathConstants.STRING).toString());


                Media media = new Media();
                media.setContent(xPath.compile("./media:content[@url]").evaluate(nodeList.item(i)));
                media.setDescription(xPath.compile("./media:content/media:description").evaluate(nodeList.item(i), XPathConstants.STRING).toString());
                media.setCredit(xPath.compile("./media:content/media:credit").evaluate(nodeList.item(i), XPathConstants.STRING).toString());

                item.setMedia(media);
                items.add(item);
            }

            channel.setItems(items);

        } catch (FeedException | IOException e) {
            e.getMessage();
        } catch (XPathExpressionException | ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
        return channel;
    }

    @Override
    public Channel getLastRss() {
        return channelRepository.getLastRss();
    }

    @Override
    public Items getItemById(Long id) {
        return itemRepository.findById(id).get();
    }

    @Override
    public Channel getChannelByItemId(Long id) {
        return itemRepository.findById(id).get().getChannel();
    }

    @Override
    public void saveItem(Items item) {
        itemRepository.save(item);
    }

}
