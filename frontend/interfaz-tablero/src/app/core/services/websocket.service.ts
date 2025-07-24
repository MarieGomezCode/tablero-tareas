import { Injectable } from '@angular/core';
import { webSocket, WebSocketSubject } from 'rxjs/webSocket';
import { Tarea } from '../models/tarea.model';
import { Observable } from 'rxjs';

@Injectable({ providedIn: 'root' })
export class WebsocketService {
  private socket$: WebSocketSubject<Tarea>;

  constructor() {
    this.socket$ = webSocket<Tarea>('ws://localhost:8080/ws/tareas');
  }

  recibirTareas(): Observable<Tarea> {
    return this.socket$.asObservable();
  }
}
