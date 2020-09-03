# Onsdags opgaverne 
I disse opgaver lærte vi om http protokollen. 

## Opgave 1-6 
Aplicationen jeg brugte til disse hedder "MonitoringHTTPHeaders". 

- opgave 1: 
Her kan vi se de forskellige headers (Cookie, Accept, Host, User-Agent, Accept-Language, Accept-Encoding, Connection) og at det er et GET request.
Derudover kan det ses at vi får et response tilbage med en status kode 200 (ok). 
Efter at have ændret index.html til index1.html, kan vi se at browseren ikke kan finde siden og vi får en response status kode 404 (Not found error). 

- opgave 2: 
Her kan vi se vi nu at vores "accept" header indeholder henholdsvis et image/png og text/css for de to nye filer der skal hentes ned. 
I connection headeren står der keep-alive. Hvilket betyder at netværks forbindelsen vil forblive åben og ikke lukkes. 

- opgave 3: 
Her skulle vi redirect en side til en anden. Dette gav os 2 HTTP-requests, den første hvortil der blev sendt et redirect response, med den nye side der skulle redirectes hentil. Og den anden request til den given side. 

- opgave 4: 
Her skulle vi teste og se forskellige response status koder. Vi fik følgende: 200(Success response), 404(Client error), 500(Server error). 

- opgave 6: 
Her kunne vi se at ved et GET request, kommer parameterene med oppe i url'en. Og ved Post bliver de gemt nede i body'en. 

## Opgave 7 og 8 
Aplicationen jeg brugte til disse hedder "SessionAndCookies". 

- opgave 7: 
Her kan vi se at der ikke bliver gemnt nogle cookies. Session "Cookies" fungere således at serveren gemmer de parameter man requster i en liste, der har en leve tid på sessions' levetid (normalt 30 min) eller man lukker browseren. 

- opgave 8: 
Her kan vi se der bliver gemt en cookie på client siden. Hvis vi lukker browseren ned og åbner den igen vil cookien stadig være der. 
