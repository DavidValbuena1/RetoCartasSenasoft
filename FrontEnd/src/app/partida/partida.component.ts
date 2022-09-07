import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-partida',
  templateUrl: './partida.component.html',
  styleUrls: ['./partida.component.css']
})
export class PartidaComponent implements OnInit {
  cantidadJugadores:any;
  jugadorCentral:any;
  listaJugadores:any;
  listaJugadoresLeft:any;
  listaJugadoresRight:any;
  abrirModalVar:any = {
    display:"block"
  }
  numeroJugadoresPartida:number = 2;
  estadoBtnEmpezar = true;
  estadoModal = false;
  existePartida = false;
  codigoPartida:any = "dd";
  existePartidaFun(){
    this.estadoModal = true;
    let partida = localStorage.getItem("dataPartida")
    if(partida){
      let codigo:any = JSON.parse(partida).codigo
      this.codigoPartida = codigo;
      console.log(this.codigoPartida);
    }
  }
  modificaAbrirModalVar(){
    /* if(this.abrirModalVar.display == "block"){

      this.abrirModalVar.display = "none";
    }
    else if(this.abrirModalVar.display == "none"){

      this.abrirModalVar.display = "block";
    } */
    this.estadoModal = true;

  }
/* Actualizacion en tiempo real --> no utilizar la variable que cambio desde el onInit si no,
     estar usando el servicio siempre , sin variables */

     abrirModal(){
      /* this.modal.display = "block"; */

      this.estadoModal = true;
     }
     cerrarModal(){
      this.estadoModal = false;
     }
  listaImagenesPerfilJugador:any = [
    {
      url:"../../assets/pokemonesImg/pokemon1.jfif"
    },
    {
      url:"../../assets/pokemonesImg/pokemon2.jfif"
    },
    {
      url:"../../assets/pokemonesImg/pokemon3.jfif"
    },
    {
      url:"../../assets/pokemonesImg/pokemon4.png"
    }

  ]

  jugador = {
    id:1,
    nombre:"Marling",
    foto:"url",
    idPartida:1,
    tipoUsuario:"administrador",
    arrayCartas:[]
  }
  constructor() { }

  ngOnInit(): void {
    this.existePartidaFun()
  }

}
