import Konva from 'konva';
import { Product } from './Product';

export class SimQueue{

    products: Product[] = []

    targetMachines: number[] = []
    
    konvaModel = new Konva.Rect({
        x: 50,
        y: 50,
        width:60,
        height:30,
        fill: 'yellow',
        stroke: 'black',
        strokeWidth: 4,
        draggable:true,
        shadowBlur : 0,
        shadowColor: 'red',
      });

      text = new Konva.Text({
        x: this.konvaModel.x() + 30,
        y: this.konvaModel.y() + 15,
        text: String(this.products.length),
        width:60,
        height:30,
        fill: 'yellow',
        stroke: 'black',
        strokeWidth: 4,
        draggable:true,
        shadowBlur : 0,
        shadowColor: 'red',
      })

      getProductsNumber(){
        return this.products.length
      }
}