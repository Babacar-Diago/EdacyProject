import {Channel} from "./channel";

export interface Items {
  id : number;
  title : string;
  pubDate : string;
  description : string;
  link : string;
  channel : Channel;
}
