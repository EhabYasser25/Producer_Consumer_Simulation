import Konva from 'konva';

export class Arrow{
    konvaModel = new Konva.Arrow({
        points: [
            0,
            0,
            0,
            0,
        ],
        pointerWidth: 4,
        fill: 'black',
        stroke: 'black',
        strokeWidth: 5,
    });
}