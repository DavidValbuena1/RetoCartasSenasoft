import { Component, OnInit } from '@angular/core';
import { CartaJugadorService } from 'src/services/carta-jugador.service';
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
  listaJugadores:any = [];
  listaJugadoresLeft:any = [];
  listaJugadoresRight:any = [];

  listajugador1:any=[];
  listajugador2:any=[];
  listajugador3:any=[];
  listajugador4:any=[];
  listajugador5:any=[];
  listajugador6:any=[];
  listajugador7:any=[];

  abrirModalVar:any = {
    display:"block"
  }
  idDeLaPartida:any;
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
            p.idpartida = this.idDeLaPartida;
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
  empezarPartida(){
    for(let i = 1; i<= this.listaJugadores.length;i++){
      let data  ={
        idusuario:this.listaJugadores[i-1].jugador.idusuario
      }
      this.listaJugadoresPorPartida.push(data);
    }

    console.log(this.listaJugadoresPorPartida);
    this.cartasJugadorService.enviarJugadores(this.listaJugadoresPorPartida);
    setTimeout(() => {
      let cont:number=0;
    for(let r of this.listaJugadores){
      cont+=1;
      console.log(cont);

      if(cont==1){
        this.cartasJugadorService.getCartasId(r.jugador.idusuario).subscribe((x:any)=>{
          this.listajugador1=x;
          console.log(this.listajugador1);
          console.log(x);

        })
      }
      if(cont==2){
        this.cartasJugadorService.getCartasId(r.jugador.idusuario).subscribe((x:any)=>{
          this.listajugador2=x;
        })
      }
      if(cont==3){
        this.cartasJugadorService.getCartasId(r.jugador.idusuario).subscribe((x:any)=>{
          this.listajugador3=x;
        })
      }
      if(cont==4){
        this.cartasJugadorService.getCartasId(r.jugador.idusuario).subscribe((x:any)=>{
          this.listajugador4=x;
        })
      }
      if(cont==5){
        this.cartasJugadorService.getCartasId(r.jugador.idusuario).subscribe((x:any)=>{
          this.listajugador5=x;
        })
      }
      if(cont==6){
        this.cartasJugadorService.getCartasId(r.jugador.idusuario).subscribe((x:any)=>{
          this.listajugador6=x;
        })
      }
      if(cont==7){
        this.cartasJugadorService.getCartasId(r.jugador.idusuario).subscribe((x:any)=>{
          this.listajugador7=x;
        })
      }
    }
    console.log(this.listajugador1);
    }, 12000);
    this.cerrarModal()
    /* this.listaJugadoresPorPartida.filter((x:any)=>{
      console.log(x);

    }) */
  }


listaJugadoresPorPartida:any = [];
  constructor(private partidaService:PartidaService,
    private jugadorPartidaService:JugadorPartidaService,
          private cartasJugadorService:CartaJugadorService) { }

  ngOnInit(): void {






    let partida = JSON.parse(localStorage.getItem("dataPartida") || "[]");

    this.partidaService.getPartidas().subscribe((x:any)=> {
      for(let p of x){

        if(p.codigo == partida.codigo){
          this.jugadorPartidaService.getJugadorPartidas(p.idpartida).subscribe((x:any)=>{
            this.listaJugadores=x;

            if(x.length<= 7){

            for(let k=1;k<=x.length;k++){
              if(k<=4){
                 /*  console.log("adios"); */

                  this.jugadorCentral = this.listaJugadores[k-1];
                  this.listaJugadoresLeft.push(this.jugadorCentral);
              }
              if(k>4){
                  this.jugadorCentral=x[k-1];
                  this.listaJugadoresRight.push(this.jugadorCentral);
              }
             /*  console.log(this.listaJugadoresLeft);
              console.log(this.listaJugadoresLeft); */


              this.numeroJugadoresPartida=x.length;
              if(this.numeroJugadoresPartida>=2){
                this.estadoBtnEmpezar=true
              }
            }

          }
          });
        }
      }

    })



    this.existePartidaFun();
  }

}
