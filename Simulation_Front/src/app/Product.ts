export class Product{
    color: string = '#000000'

    constructor(){
        this.color = `#${Math.floor(Math.random()*16777215).toString(16)}`;
    }
}