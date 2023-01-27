import { Component, OnInit } from '@angular/core';
import Konva from 'konva';
import { Machine } from '../Machine';
import { SimQueue } from '../SimQueue';
import { Arrow } from '../Arrow';
import { Product } from '../Product';
import { ProxyService } from '../ProxyService/proxy.service';
import { Command } from '../Command';
import { take } from 'rxjs';
import { WebSocketService } from '../web-socket.service';

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
  webSocketAPI: WebSocketService;
  greeting: any;
  name: string;

  constructor(private proxy: ProxyService) { }

  ngOnInit(): void {
    this.webSocketAPI = new WebSocketService(this);
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
    q0.konvaModel.x(innerWidth * 0.85).y(innerHeight * 0.45).draggable(false).id(String(this.Queues.length))
    this.Queues.push(q0)
    this.layer?.add(q0.konvaModel)
    this.layer.add(q0.setQueue())
    this.eventListeners()
  }

  addMachine(){
    let tempMachine = new Machine();
    tempMachine.konvaModel.id(String(this.Machines.length))
    this.Machines.push(tempMachine)
    this.layer?.add(tempMachine.konvaModel) 
  }

  addQueue(){
    let tempQueue = new SimQueue();
    tempQueue.konvaModel.id(String(this.Queues.length))
    this.Queues.push(tempQueue)
    this.layer?.add(tempQueue.konvaModel) 
  }

  select(tempKonv: Konva.Shape){
    tempKonv.shadowBlur(15)
    this.selected.push(tempKonv)
  }

  join(){
    if(this.selected.length != 2 || this.selected.at(0).getClassName() == this.selected.at(1).getClassName())
      return
    if(this.selected[0].x() < this.selected[1].x()) {
      let temp = this.selected[0]
      this.selected[0] = this.selected[1]
      this.selected[1] = temp;
    }
    let x1 = 0, y1 = 0, x2 = 0, y2 = 0;
    if(this.selected[0].getClassName() == 'Rect') {
      console.log('rect')
      let tmpQueue = this.Queues[Number(this.selected[0].id())]
      console.log(this.selected[0].id())
      console.log(tmpQueue)
      tmpQueue.targetMachines.push(Number(this.selected[1].id()))
      x1 = this.selected[0].x() + 4
      y1 = this.selected[0].y() + this.selected[0].height()/2
      x2 = this.selected[1].x() + this.selected[0].height()+4
      y2 = this.selected[1].y()
    }
    else {
      console.log('circ')
      let tmpMachine = this.Machines[Number(this.selected[0].id())]
      if(tmpMachine.targetQueue != undefined) return
      else tmpMachine.targetQueue = Number(this.selected[1].id())
      x1 = this.selected[0].x() - this.selected[1].height()+4
      y1 = this.selected[0].y() 
      x2 = this.selected[1].x() + this.selected[1].width()+4
      y2 = this.selected[1].y() + this.selected[1].height()/2
    }
    let tempArrow = new Arrow();
    tempArrow.konvaModel.points([x1, y1, x2, y2])
    this.layer?.add(tempArrow.konvaModel)
    this.selected[0].draggable(false)
    this.selected[1].draggable(false)
    this.emptySelected();
  }

  emptySelected(){
    for(let i = 0; i < this.selected.length; i++){ 
      this.selected.at(i).shadowBlur(0)
    }
    this.selected.splice(0, this.selected.length)
  }

  addProduct(){
    this.Queues[0].queueProduct(new Product());
  }

  startSimulation(){
    console.log(this.Machines);
    console.log(this.Queues)
    this.proxy.startSimulation(new Command(this.Machines, this.Queues)).pipe(take(1)).subscribe();
  }

  eventListeners(){
    let component = this;
    this.stage?.on('mousedown', function(e: any) {
      if(e.target.getClassName() == 'Rect' || e.target.getClassName() == 'Circle'){
        if(component.selected.includes(e.target))
          return
        component.select(e.target)
        if(e.target.getClassName() == 'Rect') console.log(component.Queues[e.target.id()])
        else console.log(component.Machines[Number(e.target.id())])
        console.log(Number(e.target.id()))
        console.log(component.selected.length)
        while(component.selected.length > 2){
          component.selected.at(0).shadowBlur(0)
          component.selected.shift()
        }
        console.log(component.selected.length)
      }
      if(e.target.getClassName() == 'Stage'){
        component.emptySelected()
      }
    })
  }

  getState() {
    console.log("state")
    this.proxy.state()
  }

}
