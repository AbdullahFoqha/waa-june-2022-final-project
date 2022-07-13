import axios from 'axios'
import keycloak from '../config/security/keycloak'


const getVal = () => (
	keycloak.token ? { 'Authorization': `Bearer ${keycloak.token}` } : {}
)

const client = axios.create({
	baseURL: 'http://localhost:9090/api',
	headers: getVal()
})

export default client
