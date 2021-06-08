# Cloud

## Login Mechanism

For Android login mechanism, we use Identity Platform from Google Cloud Platform connected via Firebase Authentication. <br/><br/>
**1. To get started you can go to the GCP console, then enable Identity Platform.**

![IdentityPlatform](https://i.ibb.co/ZmYkPTJ/Identity-Platform.png)
<br/><br/>
**2. Then you have to add a provider by clicking "ADD A PROVIDER".**

![AddProvider](https://i.ibb.co/61q7pcw/add-provider.png)
<br/><br/>

**3. Then in the Sign-in method, enable Email / Password login, then save your configuration.**

![SignInMethod](https://i.ibb.co/r4dVYXJ/Sign-in-method.png)

**4. After that, click "APPLICATION SETUP DETAILS". You will enter the application configuration page. On that page select the ANDROID tab then select "Get Started In Firebase".**


![Setup](https://i.ibb.co/Y2xWWNP/Setup-detail.png)

![Configure](https://i.ibb.co/Nx3wrzP/Configure.png)

**5. In the Firebase Console you must add your Android app to your Firebase project. You can follow the steps provided by Firebase as shown below.**

![RegisterApp](https://i.ibb.co/2nPKGnG/Register-APP.png)

![LoginJSON](https://i.ibb.co/mJ9k1rG/download-JSON-login.png)

![SDK](https://i.ibb.co/fnR9GwL/add-SDK.png)

**6. Then on the "Build" tab in your project select "Authentication".**

![FirebaseAuth](https://i.ibb.co/mDF3kzQ/Firebase-Auth.png)

**7. Then in the Sign-in-method section, activate the Email / Password provider, then save your configuration.**

![EnableLogin](https://i.ibb.co/Byp6QVv/Enable-Email.png)

**After that you have to configure Realtime Database to store user data.**


## User Data Storage
