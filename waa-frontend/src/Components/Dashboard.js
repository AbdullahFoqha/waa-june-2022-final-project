import React from 'react'
import {useKeycloak} from '@react-keycloak/web'


const Dashboard = () => {
	const { keycloak } = useKeycloak()
	return (
		<div style={{ backgroundColor: 'red', height: '100vh' }}>
			{keycloak.token}
		</div>
	)
}

export default Dashboard
