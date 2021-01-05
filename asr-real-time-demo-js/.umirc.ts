import { defineConfig } from 'umi';

export default defineConfig({
  nodeModulesTransform: {
    type: 'none',
  },
  hash: true,
  publicPath: './',
  history: { type: 'memory' },
  routes: [
    {
      path: '/',
      component: '@/pages/layout/index',
      routes: [
        {
          path: '/asr-real-time',
          component: '@/pages/layout/asrRealTime/Test',
          title: '实时语音转写_语音识别-云知声AI开放平台',
        },
        {
          path: '/',
          redirect: 'asr-real-time',
        },
      ],
    },
  ],

  theme: {
    'primary-color': '#1564FF',
    'border-radius-base': '4px',
  },
});
