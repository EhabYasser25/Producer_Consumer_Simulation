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
        fill: 'white',
        stroke: 'black',
        strokeWidth: 4,
        draggable:true,
        shadowBlur : 0,
        shadowColor: 'red',
      });

      text: Konva.Text;

      getProductsNumber(){
        return this.products.length
      }

      queueProduct(p: Product){
        this.products.push(p);
        this.konvaModel.fill(p.color);
        this.updateText()
      }

      dequeueProduct(){
        if(this.products.length == 0)
          return
        this.products.pop();
        this.updateText()
        if(this.products.length == 0)
          this.konvaModel.fill('white');
        else
          this.konvaModel.fill(this.products[this.products.length - 1].color);
      }

      setQueue(){
        this.text = new Konva.Text({
          x: this.konvaModel.x() + 25,
          y: this.konvaModel.y() - 15,
          text: String(this.products.length),
          fontSize: 13,
          align: 'center'
        });

        return this.text
      }

      updateText(){
        this.text.text(String(this.products.length))
      }
}