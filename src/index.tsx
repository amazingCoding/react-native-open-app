import { NativeModules, Platform } from 'react-native';
const openApp = Platform.OS === 'android' ? NativeModules.OpenApp?.openApp : null
export default openApp
