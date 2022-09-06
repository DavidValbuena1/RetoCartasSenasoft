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
  }

}
