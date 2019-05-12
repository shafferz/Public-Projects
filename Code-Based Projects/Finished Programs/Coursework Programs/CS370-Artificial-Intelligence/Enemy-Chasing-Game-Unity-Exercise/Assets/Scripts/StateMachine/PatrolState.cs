using UnityEngine;
using System.Collections;

public class PatrolState : IEnemyState 

{
	private readonly StatePatternEnemy enemy;
	private int nextWayPoint;

	public PatrolState (StatePatternEnemy statePatternEnemy)
	{
		enemy = statePatternEnemy;
	}

	public void UpdateState()
	{
		Look ();
		Patrol ();
	}

	public void OnTriggerEnter (Collider other)
	{
		if (other.gameObject.CompareTag ("Player")) {
			if (StatePatternEnemy.randVal > 9.0) {
				ToChaseState ();
				StatePatternEnemy.rewardScore += 10;
				StatePatternEnemy.chaseCount++;
			} else {
				ToAlertState ();
				StatePatternEnemy.rewardScore += 1;
				StatePatternEnemy.alertCount++;
			}//10% chance to just start chasing the enemy outright
		}//outer if
	}

	public void ToPatrolState()
	{
		Debug.Log ("Can't transition to same state");
	}

	public void ToAlertState()
	{
		StatePatternEnemy.rewardScore += 1;
		enemy.currentState = enemy.alertState;
	}

	public void ToChaseState()
	{
		StatePatternEnemy.rewardScore += 10;
		enemy.currentState = enemy.chaseState;
	}

	private void Look()
	{
		RaycastHit hit;
		if (Physics.Raycast (enemy.eyes.transform.position, enemy.eyes.transform.forward, out hit, enemy.sightRange) && hit.collider.CompareTag ("Player")) {
			enemy.chaseTarget = hit.transform;
			ToChaseState();
		}
	}

	void Patrol ()
	{
		enemy.meshRendererFlag.material.color = Color.green;
		enemy.navMeshAgent.destination = enemy.wayPoints [nextWayPoint].position;
		enemy.navMeshAgent.Resume ();

		if (enemy.navMeshAgent.remainingDistance <= enemy.navMeshAgent.stoppingDistance && !enemy.navMeshAgent.pathPending) {
			nextWayPoint =(nextWayPoint + 1) % enemy.wayPoints.Length;

		}


	}
}