import React from 'react'
import ReactDOM from 'react-dom/client'
import './index.css'
import {ReactKeycloakProvider} from '@react-keycloak/web'
import App from './App'
import {BrowserRouter} from 'react-router-dom'
import reportWebVitals from './reportWebVitals'
import keycloak from './config/security/keycloak'


const root = ReactDOM.createRoot(document.getElementById('root'))
root.render(<ReactKeycloakProvider authClient={keycloak}>
	<BrowserRouter>
		<App/>
	</BrowserRouter>
</ReactKeycloakProvider>)

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals()
