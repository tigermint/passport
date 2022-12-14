import { lazy } from 'react';

// project imports
import MainLayout from 'layout/MainLayout';
import Loadable from 'ui-component/Loadable';

// dashboard routing
const DashboardDefault = Loadable(lazy(() => import('views/dashboard/Default')));

// utilities routing
const UtilsTypography = Loadable(lazy(() => import('views/utilities/Typography')));
const UtilsColor = Loadable(lazy(() => import('views/utilities/Color')));
const UtilsShadow = Loadable(lazy(() => import('views/utilities/Shadow')));
const UtilsTablerIcons = Loadable(lazy(() => import('views/utilities/TablerIcons')));

// study page routing
const StudyPage = Loadable(lazy(() => import('views/StudyPage')));
const StudyCreatePage = Loadable(lazy(() => import('views/StudyCreatePage')));
const StudyDetailPage = Loadable(lazy(() => import('views/StudyDetailPage')));

// others routing
const PassportNotionPage = Loadable(lazy(() => import('views/PassportNotionPage')));

// ==============================|| MAIN ROUTING ||============================== //

const MainRoutes = {
  path: '/',
  element: <MainLayout />,
  children: [
    {
      path: '/',
      element: <DashboardDefault />
    },
    {
      path: 'dashboard',
      children: [
        {
          path: 'default',
          element: <DashboardDefault />
        }
      ]
    },
    {
      path: 'utils',
      children: [
        {
          path: 'util-typography',
          element: <UtilsTypography />
        }
      ]
    },
    {
      path: 'utils',
      children: [
        {
          path: 'util-color',
          element: <UtilsColor />
        }
      ]
    },
    {
      path: 'utils',
      children: [
        {
          path: 'util-shadow',
          element: <UtilsShadow />
        }
      ]
    },
    {
      path: 'icons',
      children: [
        {
          path: 'tabler-icons',
          element: <UtilsTablerIcons />
        }
      ]
    },
    {
      path: 'study',
      element: <StudyPage />
    },
    {
      path: 'study/create',
      element: <StudyCreatePage />
    },
    {
      path: 'study/:study__id',
      element: <StudyDetailPage />
    },
    {
      path: 'team-passport',
      element: <PassportNotionPage />
    }
  ]
};

export default MainRoutes;
