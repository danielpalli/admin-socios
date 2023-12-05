import { Routes } from '@angular/router';

export const routes: Routes = [
  {
    path: 'dashboard',
    loadComponent: () => import('./features/dashboard/dashboard.component'),
    children: [
      {
        path: '',
        title: 'Home',
        loadComponent: () => import('./features/dashboard/pages/start-page/start-page.component'),
      },
      {
        path: 'socios',
        loadComponent: () => import('./features/dashboard/pages/member-page/member-page.component'),
      },
    ],
  },
  {
    path: 'autenticacion',
    loadComponent: () => import('./features/auth/auth.component'),
    children: [
      {
        path: 'login',
        title: 'Iniciar Sesion',
        loadComponent: () => import('./features/auth/pages/login-page/login-page.component'),
      },
      {
        path: 'registro',
        title: 'Registro',
        loadComponent: () => import('./features/auth/pages/register-page/register-page.component'),
      },
      {
        path: '**',
        redirectTo: 'login',
        pathMatch: 'full',
      }
    ],
  },
  {
    path: '**',
    redirectTo: 'dashboard',
    pathMatch: 'full',
  }
];
