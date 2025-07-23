export type estadoTarea = 'POR HACER' | 'EN PROCESO' | 'TERMINADA';

export interface Tarea{
    id?:number;
    titulo:string;
    descripcion:string;
    estado:estadoTarea;
    creado?:string;
}

