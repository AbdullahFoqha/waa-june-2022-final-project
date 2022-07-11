import {Navigate} from 'react-router-dom'
import Dashboard from '../components/Dashboard'
import MainLayout from '../layout/MainLayout'
import {lazy} from 'react'


const Signup = lazy(() => import('../components/SignUp'))

const AuthRoutes = {
	path: '/',
	element: <MainLayout/>,
	children: [{
		path: '/',
		element: <Dashboard/>
	}, {
		path: '/signup',
		element: <Signup/>
	}, {
		path: '*',
		element: <Navigate to="/" replace/>
	}]
}

export default AuthRoutes
