### Tem 3 jeitos de criar uma aplicação app:

    `Nativo: Kotlin(java), objective c(swift), flutter(nativo e multiplataforma: tv, celular, watch e etc)

     Híbrido: criado com código web porém compila para app = Cordova

     Web: cria para web e é aberto pelo browser como o msite com reactjs que fica responsivo.`

Appium ou roda com nativo apenas ou com flutter, com os 2 exemplo login nativo e outra tela flutter, a
automação, vai passar pelos login mais quebrar na tela de flutter, e se for o inverso login com flutter e o resto
nativo, ele vai funcionar no flutter mais quando trocar para nativo vai quebrar.
O appium lançou uma nova biblioteca que pode resolver isso.

<br>

`Update driver do android`

`appium driver update uiautomator2 --unsafe`

`Update driver do ios`

`appium driver update xcuitest --unsafe`


`update appium`

`npm i --location=global appium`

### Step 1: Roda no terminal apppium

### Step 2: Roda o appium inspector(consulta se o mobile está no json representation e veja se tem o apk)

### Step 3: Vai dentro do código e da um play no teste que deseja
