To build locally,
download:
	Android SDK
	Android NDK
	Java JDK

	

set environment variables to the SDKs called ANDROID_SDK_ROOT, ANDROID_NDK_PATH & JAVA_HOME

Under the Android SDK folder run: tools\bin\sdkmanager.bat --licenses to accept sdk licences

run gradlew.bat assembleRelease to compile a release SDK
