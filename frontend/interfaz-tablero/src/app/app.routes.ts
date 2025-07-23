import { Routes } from '@angular/router';

export const routes: Routes = [
    {
        path:'',
        loadChildren:()=>
            import('./features/kanban/kanban.routes').then((m) => m.KANBAN_ROUTES),

    }
];
