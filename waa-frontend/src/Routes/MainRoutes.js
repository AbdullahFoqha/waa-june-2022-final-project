import {lazy} from 'react'
import {Navigate} from 'react-router-dom'
import MainLayout from '../Layout/MainLayout'


const SignupForm = lazy(() => import('../components/SignUp'))

const MainRoutes = {
	path: '/',
	element: <MainLayout/>,
	children: [
		{
			path: '/SignUp',
			element: <SignupForm/>
		},
		{
			path: '*',
			element: <Navigate to="/" replace/>
		}
	]
}

export default MainRoutes
