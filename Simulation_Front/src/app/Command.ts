import { Machine } from "./Machine";
import { SimQueue } from "./SimQueue";

export class Command{
    constructor(private machineList: Machine[], private queueList: SimQueue[]){}
}