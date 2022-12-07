import { lazy } from 'react';

// project imports
import Loadable from 'ui-component/Loadable';
import MinimalLayout from 'layout/MinimalLayout';

// login option 3 routing
const LoginPage = Loadable(lazy(() => import('views/authentication/LoginPage')));
const SignupPage = Loadable(lazy(() => import('views/authentication/SignupPage')));

// ==============================|| AUTHENTICATION ROUTING ||============================== //

const AuthenticationRoutes = {
  path: '/',
  element: <MinimalLayout />,
  children: [
    {
      path: '/login',
      element: <LoginPage />
    },
    {
      path: '/signup',
      element: <SignupPage />
    }
  ]
};

export default AuthenticationRoutes;
