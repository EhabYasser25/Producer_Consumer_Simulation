import { Component, OnInit } from '@angular/core';
import Konva from 'konva';
import { Machine } from '../Machine';
import { SimQueue } from '../SimQueue';

@Component({
  selector: 'simCanvas',
  templateUrl: './canvas.component.html',
  styleUrls: ['./canvas.component.css']
})
export class CanvasComponent implements OnInit {

  Machines: Machine[] = []
  Queues: SimQueue[] = []
  stage?: Konva.Stage;
  layer?: Konva.Layer;
  selected: Konva.Shape[] = []

  constructor() { }

  ngOnInit(): void {

    this.stage = new Konva.Stage({
      container: 'draw',   // id of container <div>
      width: innerWidth * 0.9,
      height: innerHeight * 0.9
    });
    
    // then create layer
    this.layer = new Konva.Layer();
    
    // add the layer to the stage
    this.stage.add(this.layer);
    
    // draw the image
    this.layer.draw();

    let q0 = new SimQueue()
    q0.konvaModel.x(innerWidth * 0.85).y(innerHeight * 0.45)
    this.Queues.push(q0)
    this.layer?.add(q0.konvaModel) 
    this.eventListeners()
  }

  addMachine(){
    let tempMachine = new Machine();
    this.Machines.push(tempMachine)
    this.layer?.add(tempMachine.konvaModel) 
  }

  addQueue(){
    let tempQueue = new SimQueue();
    this.Queues.push(tempQueue)
    this.layer?.add(tempQueue.konvaModel) 
  }

  select(tempKonv: Konva.Shape){
    tempKonv.shadowBlur(15)
    this.selected.push(tempKonv)
  }

  join(){
    
  }

  eventListeners(){
    let component = this;
    this.stage?.on('mousedown', function(e: any) {
      if(e.target.getClassName() == 'Rect' || e.target.getClassName() == 'Circle'){
        if(component.selected.includes(e.target))
          return
        component.select(e.target)
        console.log(component.selected.length)
        while(component.selected.length > 2){
          component.selected.at(0).shadowBlur(0)
          component.selected.splice(0, component.selected.length - 2)
        }
        console.log(component.selected.length)
      }
      if(e.target.getClassName() == 'Stage'){
        for(let i = 0; i < component.selected.length; i++){ 
          component.selected.at(i).shadowBlur(0)
        }
        component.selected.splice(0, component.selected.length)
      }
    })
  }

}
