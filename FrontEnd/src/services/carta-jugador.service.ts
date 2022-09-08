import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class CartaJugadorService {

  constructor(private http:HttpClient) { }


  enviarJugadores(data:Usuario):any{
    return this.http.post<Usuario>('https://retocartassenasoft.azurewebsites.net/Senasoft/CartasUsuarios/repartirCartas',data).subscribe((x:any)=>{
    console.log(x);

    })
  }

  getCartas():any{
    return this.http.get('https://retocartassenasoft.azurewebsites.net/Senasoft/CartasUsuarios/listar')
  }
  getCartasId(data:number):any{
    return this.http.get('https://retocartassenasoft.azurewebsites.net/Senasoft/CartasUsuarios/encontrar/' + data)
  }

}
interface Usuario{
  idusuario: number,
  nombre: string,
  partida: {
      idpartida:number,

  },
  tipoUsuario: string,
  resultado: string
}
interface cartaJugador{
  id:number,
  Carta:{
    idcarta:number
  },
  Usuario:{
    idusuario:number
  }
}
