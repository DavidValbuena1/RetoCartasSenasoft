import { Component, OnInit } from '@angular/core';
import { PartidaService } from 'src/services/partida.service';
import { JugadorPartidaService } from 'src/services/usuarioPartida.service';

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
   /*  console.log(this.partidaService.getPartidas().subscribe((y:any)=>y)); */
    if(partida){
      let codigo:any = JSON.parse(partida).codigo
      this.codigoPartida = codigo;
      /* console.log(this.codigoPartida); */
/*  SE OBTIENE LA PARTIDA */
      this.partidaService.getPartidas().subscribe((y:any)=>{
        for(let p of y){
          if(p.codigo == this.codigoPartida){
            console.log(p);
            /* this.numeroJugadoresPartida = p */
            return p
          }
        }

      })
    }
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
  constructor(private partidaService:PartidaService,
              private jugadorPartidaService:JugadorPartidaService) { }

  ngOnInit(): void {
    this.existePartidaFun()
  }

}
