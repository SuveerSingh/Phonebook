import { Routes } from '@angular/router';
import { AdminLayoutComponent } from './layouts/admin/admin-layout.component';
import { AuthLayoutComponent } from './layouts/auth/auth-layout.component';
import { AuthenticationGuard } from './authentication/authentication.guard';

export const AppRoutes: Routes = [
    {
        path: '',
        redirectTo: 'login',
        pathMatch: 'full',  
    }, {
        path: 'login',
        children: [
            {
                path: '',
                loadChildren: './login/login.module#LoginModule'
            }
        ]
    },{
        path: '',
        component: AdminLayoutComponent,        
        // canActivate: [AuthenticationGuard],
        children: [
            {
                path: '',
                loadChildren: './dashboard/dashboard.module#DashboardModule',                
            }, {
                path: 'phonebook',
                loadChildren: './phonebook/phonebook.module#PhonebookModule',                
            }, {
                path: 'phonebookentry',
                loadChildren: './phonebookentry/phonebookentry.module#PhonebookentryModule',                
            }             
        ]
    }, {
        path: '',
        component: AuthLayoutComponent,
        children: [{
            path: 'pages',
            loadChildren: './pages/pages.module#PagesModule'
        }]
    }
];
