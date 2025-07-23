import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Tarea } from '../models/tarea.model';
import { Observable } from 'rxjs';

@Injectable({providedIn: 'root'})

export class TareaService {
  private readonly apiUrl= 'http://localhost:8080/tareas';

  constructor(private http:HttpClient){}
  obtenerTodas():Observable<Tarea[]>{
    return this.http.get<Tarea[]>(this.apiUrl)
  }

  crear(tarea:Tarea):Observable<Tarea>{
    return this.http.post<Tarea>(this.apiUrl, tarea);
  }

  eliminar(id:number): Observable<void>{
    return this.http.delete<void>(`${this.apiUrl}/${id}`);
  }
}
