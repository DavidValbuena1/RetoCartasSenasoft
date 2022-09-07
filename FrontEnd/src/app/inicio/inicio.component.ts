import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
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

  crearUsuario(tipoPartida:string){
    let idPartidaCrearUsuario:any;
    let partida = JSON.parse(localStorage.getItem("dataPartida") || "[]")
/* console.log(partida); */


this.partidaService.getPartidas().subscribe((x:any)=> {
  for(let p of x){

    if(p.codigo == partida.codigo){
      idPartidaCrearUsuario = p.idpartida;
      console.log(idPartidaCrearUsuario);


      let data = {
        idusuario:0,
      nombre: this.nombreJugador,
      partida: {
          idpartida:p.idpartida,
      },
      tipoUsuario: "Administrador",
      resultado: "ganador"
      }
      try {
        console.log(data);
        this.usuarioService.postUsuario(data)
        console.log("usuario creadooooo");
      } catch (error) {
        console.log(error);

      }
      localStorage.setItem("dataUsuario", JSON.stringify(data))
      this.insercionUsuarioPartida()
    }
  }
})
    /* console.log(idPartidaCrearUsuario); */


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

/* hacer inserion en db */
    let partida = JSON.parse(localStorage.getItem("dataPartida") || "[]")
    let jugador = JSON.parse(localStorage.getItem("dataUsuario") || "[]")

    this.partidaService.getPartidas().subscribe((x:any)=> {
      for(let p of x){
        if(p.codigo == partida.codigo){
         this.idPartida = p.idpartida;
         console.log(this.idPartida);


/* --------- */
this.usuarioService.getUsuarios().subscribe((x:any)=> {
  for(let u of x){
    if(u.nombre == this.nombreJugador){

      this.idJugador = u.idusuario;
      //enviar post
      let data = {
        partida:{
            idpartida:p.idpartida
        },
        jugador:{
            idusuario:u.idusuario
        }
      }
      try{
        this.jugadorPartidaService.postJugadorPartida(data)
        this.jugadorPartidaService.getJugadorPartidas(this.idPartida).subscribe((x:any)=>x)
        this.router.navigate(['partida']);
      }catch(err){

      }

    }else{
      console.log("vuelve a enviarlo")
    }
  }

})
/* --------- */




        }
      }
    })
  /*   this.usuarioService.getUsuarios().subscribe((x:any)=> {
      for(let u of x){
        if(u.nombre == this.nombreJugador){

          this.idJugador = u.idusuario;
          //enviar post
          let data = {
            id:0,
            idpartida:p.idpartida,
            idjugador:u.idjugador
          }
          this.jugadorPartidaService.postJugadorPartida(data)
          this.jugadorPartidaService.getJugadorPartidas(this.idPartida).subscribe((x:any)=>x)
        }else{
          console.log("vuelve a enviarlo")
        }
      }

    }) */




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
    this.insercionUsuarioPartida()
    this.crearUsuario("");

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
              private jugadorPartidaService:JugadorPartidaService,
              private router:Router) { }
  ngOnInit(): void {
    this.listaUsuarios = this.usuarioService.getUsuarios().subscribe((x:any)=>{
      console.log(x);
    })
  }

}
