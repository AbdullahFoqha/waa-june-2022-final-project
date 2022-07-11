import React, {useState, useEffect} from 'react'
import {useKeycloak} from '@react-keycloak/web'


const useRole = () => {
	const { keycloak: { hasRealmRole } } = useKeycloak()

	const [isStudent, setIsStudent] = useState(false)
	const [isFaculty, setIsFaculty] = useState(false)

	useEffect(() => {
		setIsStudent(hasRealmRole('student'))
		setIsFaculty(hasRealmRole('faculty'))
	})

	return {
		isStudent,
		isFaculty
	}
}

export default useRole
