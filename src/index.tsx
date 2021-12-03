import { NativeModules } from 'react-native';

type OpenAppType = {
  multiply(a: number, b: number): Promise<number>;
};

const { OpenApp } = NativeModules;

export default OpenApp as OpenAppType;
