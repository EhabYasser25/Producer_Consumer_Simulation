import Konva from 'konva';
import { Product } from './Product';

export class Machine{

    targetQueue: number = undefined

    time: number;

    constructor(){
        this.time = Math.floor(Math.random() * (10000 - 3000 + 1) + 3000)
    }

    konvaModel = new Konva.Circle({
        x: 50,
        y: 50,
        radius: 30,
        fill: `white`,
        stroke: 'black',
        strokeWidth: 4,
        draggable:true,
        shadowBlur : 0,
        shadowColor: 'yellow'
    });

    consumeProduct(p: Product) {
        this.konvaModel.fill(p.color)
    }
}