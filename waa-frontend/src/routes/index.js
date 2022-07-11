import {useRoutes} from 'react-router-dom'
import AuthRoutes from './AuthRoutes'
import MainRoutes from './MainRoutes'
import {useKeycloak} from '@react-keycloak/web'


const Routes = () => {
	const { keycloak: { authenticated: isLoggedIn } } = useKeycloak()

	const ActiveRoutes = isLoggedIn ? MainRoutes : AuthRoutes
	return useRoutes([ActiveRoutes])
}

export default Routes
