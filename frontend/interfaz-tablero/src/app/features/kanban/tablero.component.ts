import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { TareaService } from '../../core/services/tarea.service';
import { Tarea } from '../../core/models/tarea.model';
import { CdkDragDrop, moveItemInArray, transferArrayItem, DragDropModule } from '@angular/cdk/drag-drop';

@Component({
  selector: 'app-tablero',
  standalone: true,
  imports: [CommonModule, DragDropModule], // ✅ Esto es clave
  templateUrl: './tablero.component.html',
  styleUrl: './tablero.component.scss',
})
export class TableroComponent implements OnInit {
  tareas: Tarea[] = [];

  constructor(private tareaService: TareaService) {}

  ngOnInit(): void {
    this.tareaService.obtenerTodas().subscribe((res) => (this.tareas = res));
  }

  obtenerPorEstado(estado: string): Tarea[] {
    return this.tareas.filter((t) => t.estado === estado);
  }

  cambiarEstado(event: CdkDragDrop<Tarea[]>, nuevoEstado: string) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      const tarea = event.previousContainer.data[event.previousIndex];
      tarea.estado = nuevoEstado as any;

      this.tareaService.crear(tarea).subscribe(() => {
        transferArrayItem(
          event.previousContainer.data,
          event.container.data,
          event.previousIndex,
          event.currentIndex
        );
      });
    }
  }
}
