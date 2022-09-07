import { Component, OnInit } from '@angular/core';
import { PartidaService } from 'src/services/partida.service';
import { UsuarioService } from 'src/services/usuario.service';

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
    let data = {
      idusuario:0,
    nombre: this.nombreJugador,
    partida: {
        idpartida:0,
    },
    tipoUsuario: "Administrador",
    resultado: "ganador"
    }
    this.usuarioService.postUsuario(data)
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
  /* CREACION DE UNA PARTIDA */
  crearPartida(){
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
    console.log("partida creada");

  } catch (error) {
    console.log(error);
  }
/* this.partidaService.getPartidas().subscribe((x:any)=>x); */
  /* console.log(this.colorHEX()) */
    /* crearUsuario() */
  }
  /*  */
  listaUsuarios:any;
  constructor(private usuarioService:UsuarioService,
              private partidaService:PartidaService) { }
  ngOnInit(): void {
    this.listaUsuarios = this.usuarioService.getUsuarios().subscribe((x:any)=>{
      console.log(x);
    })
  }

}
