import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {
  btnDisabled = true;
  nombreJugador:any = "";
  existeUnNombre(){
    if(this.nombreJugador != ""){
      this.btnDisabled = false
      console.log(this.nombreJugador);
    }
  }
  constructor() { }
  ngOnInit(): void {
  }

}
