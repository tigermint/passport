// assets
import {
  IconBrandChrome,
  IconDashboard,
  IconNotebook,
  IconUser,
  IconTypography,
  IconPalette,
  IconShadow,
  IconWindmill
} from '@tabler/icons';

// constant
const icons = { IconBrandChrome, IconDashboard, IconNotebook, IconUser, IconTypography, IconPalette, IconShadow, IconWindmill };

const all = {
  id: 'all',
  title: '전체 메뉴',
  type: 'group',
  children: [
    {
      id: 'default',
      title: '대시보드',
      type: 'item',
      url: '/dashboard/default',
      icon: icons.IconDashboard,
      breadcrumbs: false
    },
    {
      id: 'study',
      title: '스터디',
      type: 'item',
      url: '/study',
      icon: icons.IconNotebook,
      breadcrumbs: false
    },
    {
      id: 'mypage',
      title: '마이페이지',
      type: 'item',
      url: '/mypage',
      icon: icons.IconUser,
      breadcrumbs: false
    }
    // {
    //   id: 'util-typography',
    //   title: 'Typography',
    //   type: 'item',
    //   url: '/utils/util-typography',
    //   icon: icons.IconTypography,
    //   breadcrumbs: false
    // },
    // {
    //   id: 'util-color',
    //   title: 'Color',
    //   type: 'item',
    //   url: '/utils/util-color',
    //   icon: icons.IconPalette,
    //   breadcrumbs: false
    // },
    // {
    //   id: 'util-shadow',
    //   title: 'Shadow',
    //   type: 'item',
    //   url: '/utils/util-shadow',
    //   icon: icons.IconShadow,
    //   breadcrumbs: false
    // },
    // {
    //   id: 'icons',
    //   title: 'Icons',
    //   type: 'collapse',
    //   icon: icons.IconWindmill,
    //   children: [
    //     {
    //       id: 'tabler-icons',
    //       title: 'Tabler Icons',
    //       type: 'item',
    //       url: '/icons/tabler-icons',
    //       breadcrumbs: false
    //     }
    //   ]
    // },
    // {
    //   id: 'sample-page',
    //   title: 'Sample Page',
    //   type: 'item',
    //   url: '/sample-page',
    //   icon: icons.IconBrandChrome,
    //   breadcrumbs: false
    // }
  ]
};

export default all;
