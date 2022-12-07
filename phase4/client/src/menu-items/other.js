// assets
import { IconStar } from '@tabler/icons';

// constant
const icons = { IconStar };

// ==============================|| SAMPLE PAGE & DOCUMENTATION MENU ITEMS ||============================== //

const other = {
  id: 'sample-docs-roadmap',
  type: 'group',
  children: [
    {
      id: 'team-passport',
      title: 'Team-passport',
      type: 'item',
      url: '/team-passport',
      icon: icons.IconStar,
      breadcrumbs: false
    }
  ]
};

export default other;
