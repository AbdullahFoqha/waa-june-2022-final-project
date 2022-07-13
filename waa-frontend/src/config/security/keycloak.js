import Keycloak from 'keycloak-js'


const keycloak = new Keycloak({
	url: 'http://localhost:8080',
	clientId: 'waa-frontend',
	realm: 'waa-server'
})

keycloak.init()

export default keycloak
