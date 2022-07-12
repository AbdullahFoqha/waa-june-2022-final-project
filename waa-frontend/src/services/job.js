import client from "./client";

const baseUrl = "/jobs";

export const getTags = async () => await client.get(`${baseUrl}` + "/tags");
export const getStates = async () => await client.get(`${baseUrl}` + "/states");
export const getCities = async () => await client.get(`${baseUrl}` + "/cities");
export const addJobAdvertisement = async (jobAdvObj) =>
  await client.post(`${baseUrl}`, jobAdvObj);
