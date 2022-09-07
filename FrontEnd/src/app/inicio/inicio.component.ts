import { Component, OnInit } from '@angular/core';
import { PartidaService } from 'src/services/partida.service';
import { UsuarioService } from 'src/services/usuario.service';
import { JugadorPartidaService } from 'src/services/usuarioPartida.service';

@Component({
  selector: 'app-inicio',
  templateUrl: './inicio.component.html',
  styleUrls: ['./inicio.component.css']
})
export class InicioComponent implements OnInit {
  btnDisabled = true;
  nombreJugador:any = "";
  codigoPartida:any = "";
  btnDisabledUnirme:any = true;

  existeUnNombre(){
    if(this.nombreJugador != ""){
      this.btnDisabled = false
    }
  }
  existeUnCodigo(){
    if(this.codigoPartida != ""){
      this.btnDisabledUnirme = false
      console.log(this.listaUsuarios);

    }
  }
  /*  */
  idPartidaCrearUsuario:any;
  crearUsuario(tipoPartida:string){
    let partida = JSON.parse(localStorage.getItem("dataPartida") || "[]")
/* console.log(partida); */


this.partidaService.getPartidas().subscribe((x:any)=> {
  for(let p of x){

    if(p.codigo == partida.codigo){
      console.log(this.idPartida);
     this.idPartida = p.idpartida;
    }
  }
})

    let data = {
      idusuario:0,
    nombre: this.nombreJugador,
    partida: {
        idpartida:this.idPartidaCrearUsuario,
    },
    tipoUsuario: "Administrador",
    resultado: "ganador"
    }
    try {

      this.usuarioService.postUsuario(data)
      console.log("usuario creado");
      console.log(data);


    } catch (error) {
      console.log(error);

    }
    localStorage.setItem("dataUsuario", JSON.stringify(data))
    this.insercionUsuarioPartida()
  }
  /* CREACION CODIGO HEXADECIMAL ALEATORIO */
  generarLetra(){
    let letras:any = ["a","b","c","d","e","f","0","1","2","3","4","5","6","7","8","9"];
    let numero:any = (Math.random()*15).toFixed(0);
    return letras[numero];
  }
  colorHEX(){
    let coolor = "";
    for(let i=0;i<6;i++){
      coolor = coolor + this.generarLetra() ;
    }
    return  coolor;
  }
   /*  INSERCION A TABLA USUARIO PARTIDA */
   idPartida:any;
   idJugador:any;
   insercionUsuarioPartida(){


    let partida = JSON.parse(localStorage.getItem("dataPartida") || "[]")
    let jugador = JSON.parse(localStorage.getItem("dataUsuario") || "[]")

    this.partidaService.getPartidas().subscribe((x:any)=> {
      for(let p of x){
        if(p.codigo == partida.codigo){
         this.idPartida = p.idpartida;
        }
      }
    })
    this.usuarioService.getUsuarios().subscribe((x:any)=> {
      for(let p of x){
        console.log(p.nombre);

        if(p.nombre == this.nombreJugador){
          console.log(p);
         this.idJugador = p.idusuario;
        }
      }

    })


    /* console.log(this.jugadorPartidaService.getJugadorPartidas(this.idPartida).subscribe((x:any)=>x)) */
   }
  /* CREACION DE UNA PARTIDA */
  crearPartida(){
    // aqui pobtengo el id usuario creado ahorita
    let data = {
      /* idpartida: 0, */
      codigo: this.colorHEX(),
      estado: 1,
      rondas: 0,
      resultado: "En espera"
  }
  localStorage.setItem("dataPartida", JSON.stringify(data))

  try {
    console.log(data);
    this.partidaService.postPartida(data);
    this.crearUsuario("");

  /*   this.crearUsuario("") */
    console.log("partida creada");


  } catch (error) {
    console.log(error);
  }
/* this.partidaService.getPartidas().subscribe((x:any)=>x); */
  /* console.log(this.colorHEX()) */

  }
  /*  */
  listaUsuarios:any;
  constructor(private usuarioService:UsuarioService,
              private partidaService:PartidaService,
              private jugadorPartidaService:JugadorPartidaService) { }
  ngOnInit(): void {
    this.listaUsuarios = this.usuarioService.getUsuarios().subscribe((x:any)=>{
      console.log(x);
    })
  }

}
