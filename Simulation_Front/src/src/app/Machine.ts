import Konva from 'konva';

export class Machine{

    resourcesQueues: number[] = []

    targetQueue: number = undefined

    currentProduct = ''

    konvaModel = new Konva.Circle({
        x: 50,
        y: 50,
        radius: 30,
        fill: 'red',
        stroke: 'black',
        strokeWidth: 4,
        draggable:true,
        shadowBlur : 0,
        shadowColor: 'yellow'
      });
}