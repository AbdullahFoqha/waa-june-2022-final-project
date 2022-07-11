import {Navigate} from 'react-router-dom'
import Dashboard from '../components/Dashboard'
import MainLayout from '../layout/MainLayout'


const AuthRoutes = {
	path: '/',
	element: <MainLayout/>,
	children: [{
		path: '/',
		element: <Dashboard/>
	}, {
		path: '*',
		element: <Navigate to="/" replace/>
	}]
}

export default AuthRoutes
