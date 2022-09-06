import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
@Injectable({
  providedIn: 'root'
})
export class PartidaService {

  constructor(private http: HttpClient) {}
  getPartidas():any{
    return  this.http.get('https://retocartassenasoft.azurewebsites.net/Senasoft/Partida/listar')
  }


  postPartida(data:Partida):any{
    return this.http.post<Partida>('https://retocartassenasoft.azurewebsites.net/Senasoft/Partida/agregar',data).subscribe((x:any)=>console.log(x))
  }
}
interface Partida {
/*   idpartida: number, */
  codigo: string,
  estado: number,
  rondas: number,
  resultado: string
}
