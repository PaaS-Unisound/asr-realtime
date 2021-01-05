export enum AiCode {
  Real = 'asr-real-time',
}

export const Config = {
  [AiCode.Real]: {
    appKey: 'appKey',
    secret: 'secret',
    path: 'servicePath',
  },
};
