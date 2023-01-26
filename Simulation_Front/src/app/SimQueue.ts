import Konva from 'konva';

export class SimQueue{
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
        shadowColor: 'red'
      });
}