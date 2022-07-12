import axios from 'axios'
import keycloak from '../config/security/keycloak'


const client = axios.create({
	baseURL: 'http://localhost:9090/api',
	headers: { 'Authorization': `Bearer ${keycloak.token}` }
})

export default client
